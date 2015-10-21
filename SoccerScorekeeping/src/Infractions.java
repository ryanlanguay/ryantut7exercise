/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/



// line 20 "soccerExercise.ump"
public class Infractions
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Infractions Attributes
  private Enum Type;

  //Infractions Associations
  private Player player;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Infractions(Enum aType, Player aPlayer)
  {
    Type = aType;
    boolean didAddPlayer = setPlayer(aPlayer);
    if (!didAddPlayer)
    {
      throw new RuntimeException("Unable to create infraction due to player");
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
      existingPlayer.removeInfraction(this);
    }
    player.addInfraction(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Player placeholderPlayer = player;
    this.player = null;
    placeholderPlayer.removeInfraction(this);
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