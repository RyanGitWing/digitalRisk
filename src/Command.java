/**
 * @author Ryan Nguyen
 * @version 10.25.2020
 *
 * @author Fareen. L
 * @version 11.09.2020
 */

public class Command
{
    private final String commandWord;
    private final String secondWord;

    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null.
     * @param firstWord The first word of the command. Null if the command was not recognised.
     * @param secondWord The second word of the command.
     */
    public Command(String firstWord, String secondWord)
    {
        this.commandWord = firstWord;
        this.secondWord = secondWord;
    }

    /**
     * Return the command word (the first word) of this command. If the
     * command was not understood, the result is null.
     *
     * @return The command word.
     */
    public String getCommandWord()
    {
        return commandWord;
    }

    /**
     * Return the second command world. Returns null if there is no second word.
     *
     * @return The second word of this command.
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * Checks if the command is null.
     *
     * @return true if this command was not understood.
     */
    public boolean isUnknown()
    {
        return (commandWord == null);
    }

    /**
     * Checks to see if the command has a second word.
     *
     * @return true if the command has a second word.
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}

