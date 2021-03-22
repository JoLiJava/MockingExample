package calculator;

public class Calculator {

    // String test = "2,4";

    public int add(String numbers) {

        String[] arrayNumbers;
        int addingNumbers = 0;
        boolean illegalException = false;
        StringBuilder negativeNumbers = new StringBuilder();

        arrayNumbers = numbers.split("[/\n;,]");
        for (String number : arrayNumbers) {
            if (!number.isEmpty()) {
                addingNumbers += Integer.parseInt(number);

                if (Integer.parseInt(number) < 0) {
                    illegalException = true;
                    negativeNumbers.append(" ").append(number);

                }
            }
        }

        if (illegalException) {
            throw new IllegalArgumentException("negatives not allowed" + negativeNumbers);
        }

        return addingNumbers;
    }
}
