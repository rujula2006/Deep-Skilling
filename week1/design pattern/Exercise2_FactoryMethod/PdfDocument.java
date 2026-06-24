package Exercise2_FactoryMethod;
public class PdfDocument implements Document {

    @Override
    public void open() {
        System.out.println("PDF Document Opened");
    }
}
