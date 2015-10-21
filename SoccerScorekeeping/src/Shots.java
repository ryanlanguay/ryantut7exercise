/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/



// line 26 "soccerExercise.ump"
public class Shots
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Shots Attributes
  private Enum Type;

  //Shots Associations
  private Player player;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Shots(Enum aType, Player aPlayer)
  {
    Type = aType;
    boolean didAddPlayer = setPlayer(aPlayer);
    if (!didAddPlayer)
    {
      throw new RuntimeException("Unable to create shot due to player");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setType(Enum aType)
  {
    boolean wasSet = false;
    Type = aType;
    wasSet = true;
    return wasSet;
  }

  public Enum getType()
  {
    return Type;
  }

  public Player getPlayer()
  {
    return player;
  }

  public boolean setPlayer(Player aPlayer)
  {
    boolean wasSet = false;
    if (aPlayer == null)
    {
      return wasSet;
    }

    Player existingPlayer = player;
    player = aPlayer;
    if (existingPlayer != null && !existingPlayer.equals(aPlayer))
    {
      existingPlayer.removeShot(this);
    }
    player.addShot(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Player placeholderPlayer = player;
    this.player = null;
    placeholderPlayer.removeShot(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "Type" + "=" + (getType() != null ? !getType().equals(this)  ? getType().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "player = "+(getPlayer()!=null?Integer.toHexString(System.identityHashCode(getPlayer())):"null")
     + outputString;
  }
}