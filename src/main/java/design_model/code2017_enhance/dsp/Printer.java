package design_model.code2017_enhance.dsp;

/**
 * 没有使用dsp原则的
 * Created by lx on 2017/9/16.
 */
public class Printer {
    Document doc;
    HtmlFormatter htmlFormatter;
    PdfFormatter pdfFormatter;

    private void print(String text) {

    }

}

class Document {}

class HtmlFormatter {}

class PdfFormatter {}

/**
 * oo设计后的
 */
class Printer2 {
    Document doc;
    Formattter formattter;

    public void print(Document doc) {
        String txt = formattter.format(doc);
        print(txt);
    }

    private void print(String t) {

    }

}

class Formattter {
    public String format(Document doc) {
        return "";
    }
}

