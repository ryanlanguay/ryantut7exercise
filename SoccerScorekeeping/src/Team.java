/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/


import java.util.*;

// line 7 "soccerExercise.ump"
public class Team
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Team Attributes
  private String name;

  //Team Associations
  private Match match;
  private List<Player> players;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Team(String aName, Match aMatch)
  {
    name = aName;
    boolean didAddMatch = setMatch(aMatch);
    if (!didAddMatch)
    {
      throw new RuntimeException("Unable to create team due to match");
    }
    players = new ArrayList<Player>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public Match getMatch()
  {
    return match;
  }

  public Player getPlayer(int index)
  {
    Player aPlayer = players.get(index);
    return aPlayer;
  }

  public List<Player> getPlayers()
  {
    List<Player> newPlayers = Collections.unmodifiableList(players);
    return newPlayers;
  }

  public int numberOfPlayers()
  {
    int number = players.size();
    return number;
  }

  public boolean hasPlayers()
  {
    boolean has = players.size() > 0;
    return has;
  }

  public int indexOfPlayer(Player aPlayer)
  {
    int index = players.indexOf(aPlayer);
    return index;
  }

  public boolean setMatch(Match aMatch)
  {
    boolean wasSet = false;
    //Must provide match to team
    if (aMatch == null)
    {
      return wasSet;
    }

    //match already at maximum (2)
    if (aMatch.numberOfTeams() >= Match.maximumNumberOfTeams())
    {
      return wasSet;
    }
    
    Match existingMatch = match;
    match = aMatch;
    if (existingMatch != null && !existingMatch.equals(aMatch))
    {
      boolean didRemove = existingMatch.removeTeam(this);
      if (!didRemove)
      {
        match = existingMatch;
        return wasSet;
      }
    }
    match.addTeam(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfPlayers()
  {
    return 0;
  }

  public Player addPlayer(int aID, int aPosition)
  {
    return new Player(aID, aPosition, this);
  }

  public boolean addPlayer(Player aPlayer)
  {
    boolean wasAdded = false;
    if (players.contains(aPlayer)) { return false; }
    Team existingTeam = aPlayer.getTeam();
    boolean isNewTeam = existingTeam != null && !this.equals(existingTeam);
    if (isNewTeam)
    {
      aPlayer.setTeam(this);
    }
    else
    {
      players.add(aPlayer);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePlayer(Player aPlayer)
  {
    boolean wasRemoved = false;
    //Unable to remove aPlayer, as it must always have a team
    if (!this.equals(aPlayer.getTeam()))
    {
      players.remove(aPlayer);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPlayerAt(Player aPlayer, int index)
  {  
    boolean wasAdded = false;
    if(addPlayer(aPlayer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPlayers()) { index = numberOfPlayers() - 1; }
      players.remove(aPlayer);
      players.add(index, aPlayer);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePlayerAt(Player aPlayer, int index)
  {
    boolean wasAdded = false;
    if(players.contains(aPlayer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPlayers()) { index = numberOfPlayers() - 1; }
      players.remove(aPlayer);
      players.add(index, aPlayer);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPlayerAt(aPlayer, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Match placeholderMatch = match;
    this.match = null;
    placeholderMatch.removeTeam(this);
    for(int i=players.size(); i > 0; i--)
    {
      Player aPlayer = players.get(i - 1);
      aPlayer.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "match = "+(getMatch()!=null?Integer.toHexString(System.identityHashCode(getMatch())):"null")
     + outputString;
  }
}