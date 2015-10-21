/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/


import java.util.*;

// line 1 "soccerExercise.ump"
public class Match
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Match Attributes
  private int ID;

  //Match Associations
  private List<Team> teams;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Match(int aID)
  {
    ID = aID;
    teams = new ArrayList<Team>();
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

  public int getID()
  {
    return ID;
  }

  public Team getTeam(int index)
  {
    Team aTeam = teams.get(index);
    return aTeam;
  }

  public List<Team> getTeams()
  {
    List<Team> newTeams = Collections.unmodifiableList(teams);
    return newTeams;
  }

  public int numberOfTeams()
  {
    int number = teams.size();
    return number;
  }

  public boolean hasTeams()
  {
    boolean has = teams.size() > 0;
    return has;
  }

  public int indexOfTeam(Team aTeam)
  {
    int index = teams.indexOf(aTeam);
    return index;
  }

  public boolean isNumberOfTeamsValid()
  {
    boolean isValid = numberOfTeams() >= minimumNumberOfTeams() && numberOfTeams() <= maximumNumberOfTeams();
    return isValid;
  }

  public static int requiredNumberOfTeams()
  {
    return 2;
  }

  public static int minimumNumberOfTeams()
  {
    return 2;
  }

  public static int maximumNumberOfTeams()
  {
    return 2;
  }

  public Team addTeam(String aName)
  {
    if (numberOfTeams() >= maximumNumberOfTeams())
    {
      return null;
    }
    else
    {
      return new Team(aName, this);
    }
  }

  public boolean addTeam(Team aTeam)
  {
    boolean wasAdded = false;
    if (teams.contains(aTeam)) { return false; }
    if (numberOfTeams() >= maximumNumberOfTeams())
    {
      return wasAdded;
    }

    Match existingMatch = aTeam.getMatch();
    boolean isNewMatch = existingMatch != null && !this.equals(existingMatch);

    if (isNewMatch && existingMatch.numberOfTeams() <= minimumNumberOfTeams())
    {
      return wasAdded;
    }

    if (isNewMatch)
    {
      aTeam.setMatch(this);
    }
    else
    {
      teams.add(aTeam);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTeam(Team aTeam)
  {
    boolean wasRemoved = false;
    //Unable to remove aTeam, as it must always have a match
    if (this.equals(aTeam.getMatch()))
    {
      return wasRemoved;
    }

    //match already at minimum (2)
    if (numberOfTeams() <= minimumNumberOfTeams())
    {
      return wasRemoved;
    }
    teams.remove(aTeam);
    wasRemoved = true;
    return wasRemoved;
  }

  public void delete()
  {
    for(int i=teams.size(); i > 0; i--)
    {
      Team aTeam = teams.get(i - 1);
      aTeam.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "ID" + ":" + getID()+ "]"
     + outputString;
  }
}