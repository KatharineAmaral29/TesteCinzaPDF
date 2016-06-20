import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PrimeiroPDF {
    public static void main(String[] args) throws Exception {
        Document doc = null;
        OutputStream os = null;
		
        try {
            //cria o documento tamanho A4, margens de 2,54cm
            doc = new Document(PageSize.A4, 72, 72, 72, 72);
			
            //cria a stream de saída
            os = new FileOutputStream("meupdf.pdf");
			
            //associa a stream de saída ao 
            PdfWriter.getInstance(doc, os);
			
            //abre o documento
            doc.open();

            //adiciona o texto ao PDF
            Paragraph p = new Paragraph("Meu primeiro arquivo PDF! Aqui embaixo é para aparecer as imagens");
            Image img = Image.getInstance("1.jpg"); //Pega imagens da pasta e bota no pdf
            Image img2 = Image.getInstance("grayscale.jpg");
            img.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);
            doc.add(img);
            doc.add(img2);
            
        } finally {
            if (doc != null) {
                //fechamento do documento
                doc.close();
            }
            if (os != null) {
               //fechamento da stream de saída
               os.close();
            }
        }
    }
}