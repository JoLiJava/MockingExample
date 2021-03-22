package calculator;

public class Calculator {

    // String test = "2,4";

    public int add(String numbers) {

        String[] arrayNumbers;
        int addingNumbers = 0;

        arrayNumbers = numbers.split("[/\n;,]");
        for (String arrayNumber : arrayNumbers) {
            if (!arrayNumber.isEmpty()) {
                addingNumbers += Integer.parseInt(arrayNumber);
            }
        }
        return addingNumbers;
    }
}
