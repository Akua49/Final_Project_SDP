package structural.adapter;

public class ReceiptAdapter implements NewPrinter {
    private OldPrinter oldPrinter;

    public ReceiptAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    public void print(String text) {
        oldPrinter.printOld(text);
    }
}