package exceptions;

/**
 * This class handles format exceptions for operations
 * such as adding and deleting a student.
 */
public class SEPFormatException extends SEPException {
    public SEPFormatException(String message) {
        super(message);
    }

    public static SEPFormatException rejectAddStudentFormat() {
        return new SEPFormatException("Invalid add student format. Please use: "
                + "add id/<Id> gpa/<GPA> p/{<Preference Rankings>}");
    }

    public static SEPFormatException rejectGpaFormat() {
        return new SEPFormatException("Invalid gpa format. Please enter a valid float "
                + "with a maximum of 2 decimal places.");
    }

    public static SEPFormatException rejectPreferenceFormat() {
        return new SEPFormatException("Invalid preference format. "
                + "Please enter a valid integer with curly braces enclosing it.");
    }

    public static SEPFormatException rejectIdFormat() {
        return new SEPFormatException("Invalid ID format. Please enter two uppercase alphabets "
                + "with 7 natural numbers between it.");
    }

    public static SEPFormatException rejectStatFormat() {
        return new SEPFormatException("Invalid format for stats command. "
                + "Usage: ``stats -avggpa <UNI_INDEX>`` or ``stats -mingpa <UNI_INDEX>``.");
    }

    public static SEPFormatException rejectViewQuotaFormat() {
        return new SEPFormatException("Invalid format for viewQuota command. "
                + "Usage: ``viewQuota <UNI_INDEX>``.");
    }

    public static SEPFormatException rejectFindFormat() {
        return new SEPFormatException("Invalid find format. Please enter: " +
                "'find <report/list> <Keyword>' ");
    }
}
