/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/


import java.util.*;

// line 12 "soccerExercise.ump"
public class Player
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Player Attributes
  private int ID;
  private int Position;

  //Player Associations
  private Team team;
  private List<Shots> shots;
  private List<Infractions> infractions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Player(int aID, int aPosition, Team aTeam)
  {
    ID = aID;
    Position = aPosition;
    boolean didAddTeam = setTeam(aTeam);
    if (!didAddTeam)
    {
      throw new RuntimeException("Unable to create player due to team");
    }
    shots = new ArrayList<Shots>();
    infractions = new ArrayList<Infractions>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setID(int aID)
  {
    boolean wasSet = false;
    ID = aID;
    wasSet = true;
    return wasSet;
  }

  public boolean setPosition(int aPosition)
  {
    boolean wasSet = false;
    Position = aPosition;
    wasSet = true;
    return wasSet;
  }

  public int getID()
  {
    return ID;
  }

  public int getPosition()
  {
    return Position;
  }

  public Team getTeam()
  {
    return team;
  }

  public Shots getShot(int index)
  {
    Shots aShot = shots.get(index);
    return aShot;
  }

  public List<Shots> getShots()
  {
    List<Shots> newShots = Collections.unmodifiableList(shots);
    return newShots;
  }

  public int numberOfShots()
  {
    int number = shots.size();
    return number;
  }

  public boolean hasShots()
  {
    boolean has = shots.size() > 0;
    return has;
  }

  public int indexOfShot(Shots aShot)
  {
    int index = shots.indexOf(aShot);
    return index;
  }

  public Infractions getInfraction(int index)
  {
    Infractions aInfraction = infractions.get(index);
    return aInfraction;
  }

  public List<Infractions> getInfractions()
  {
    List<Infractions> newInfractions = Collections.unmodifiableList(infractions);
    return newInfractions;
  }

  public int numberOfInfractions()
  {
    int number = infractions.size();
    return number;
  }

  public boolean hasInfractions()
  {
    boolean has = infractions.size() > 0;
    return has;
  }

  public int indexOfInfraction(Infractions aInfraction)
  {
    int index = infractions.indexOf(aInfraction);
    return index;
  }

  public boolean setTeam(Team aTeam)
  {
    boolean wasSet = false;
    if (aTeam == null)
    {
      return wasSet;
    }

    Team existingTeam = team;
    team = aTeam;
    if (existingTeam != null && !existingTeam.equals(aTeam))
    {
      existingTeam.removePlayer(this);
    }
    team.addPlayer(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfShots()
  {
    return 0;
  }

  public Shots addShot(Enum aType)
  {
    return new Shots(aType, this);
  }

  public boolean addShot(Shots aShot)
  {
    boolean wasAdded = false;
    if (shots.contains(aShot)) { return false; }
    Player existingPlayer = aShot.getPlayer();
    boolean isNewPlayer = existingPlayer != null && !this.equals(existingPlayer);
    if (isNewPlayer)
    {
      aShot.setPlayer(this);
    }
    else
    {
      shots.add(aShot);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeShot(Shots aShot)
  {
    boolean wasRemoved = false;
    //Unable to remove aShot, as it must always have a player
    if (!this.equals(aShot.getPlayer()))
    {
      shots.remove(aShot);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addShotAt(Shots aShot, int index)
  {  
    boolean wasAdded = false;
    if(addShot(aShot))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfShots()) { index = numberOfShots() - 1; }
      shots.remove(aShot);
      shots.add(index, aShot);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveShotAt(Shots aShot, int index)
  {
    boolean wasAdded = false;
    if(shots.contains(aShot))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfShots()) { index = numberOfShots() - 1; }
      shots.remove(aShot);
      shots.add(index, aShot);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addShotAt(aShot, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfInfractions()
  {
    return 0;
  }

  public Infractions addInfraction(Enum aType)
  {
    return new Infractions(aType, this);
  }

  public boolean addInfraction(Infractions aInfraction)
  {
    boolean wasAdded = false;
    if (infractions.contains(aInfraction)) { return false; }
    Player existingPlayer = aInfraction.getPlayer();
    boolean isNewPlayer = existingPlayer != null && !this.equals(existingPlayer);
    if (isNewPlayer)
    {
      aInfraction.setPlayer(this);
    }
    else
    {
      infractions.add(aInfraction);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeInfraction(Infractions aInfraction)
  {
    boolean wasRemoved = false;
    //Unable to remove aInfraction, as it must always have a player
    if (!this.equals(aInfraction.getPlayer()))
    {
      infractions.remove(aInfraction);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addInfractionAt(Infractions aInfraction, int index)
  {  
    boolean wasAdded = false;
    if(addInfraction(aInfraction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInfractions()) { index = numberOfInfractions() - 1; }
      infractions.remove(aInfraction);
      infractions.add(index, aInfraction);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveInfractionAt(Infractions aInfraction, int index)
  {
    boolean wasAdded = false;
    if(infractions.contains(aInfraction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInfractions()) { index = numberOfInfractions() - 1; }
      infractions.remove(aInfraction);
      infractions.add(index, aInfraction);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addInfractionAt(aInfraction, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Team placeholderTeam = team;
    this.team = null;
    placeholderTeam.removePlayer(this);
    for(int i=shots.size(); i > 0; i--)
    {
      Shots aShot = shots.get(i - 1);
      aShot.delete();
    }
    for(int i=infractions.size(); i > 0; i--)
    {
      Infractions aInfraction = infractions.get(i - 1);
      aInfraction.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "ID" + ":" + getID()+ "," +
            "Position" + ":" + getPosition()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "team = "+(getTeam()!=null?Integer.toHexString(System.identityHashCode(getTeam())):"null")
     + outputString;
  }
}