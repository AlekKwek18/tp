package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_INDEX_RANGE;
import static seedu.address.logic.Messages.MESSAGE_MISSING_INDEX;
import static seedu.address.logic.Messages.MESSAGE_UNKNOWN_COMMAND;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.ViewCompanyCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ViewCompanyCommand object.
 */
public class ViewCompanyCommandParser implements Parser<ViewCompanyCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of a ViewCompanyCommand
     * and returns a ViewCompanyCommand object for execution.
     *
     * @throws ParseException if the user input does not conform to the expected format.
     */
    public ViewCompanyCommand parse(String args) throws ParseException {

        String[] splitArgs = args.trim().split("\\s+");

        if (args.isEmpty() || !splitArgs[0].equals("company")) {
            throw new ParseException(ViewCompanyCommand.MESSAGE_USAGE);

        }

        if (splitArgs.length == 1) {
            throw new ParseException(MESSAGE_MISSING_INDEX);
        }

        String indexString = splitArgs[1];
        try {
            Index index = ParserUtil.parseIndex(indexString);
            return new ViewCompanyCommand(index);
        } catch (ParseException e) {
            throw new ParseException(MESSAGE_INVALID_INDEX_RANGE);
        }
    }
}
