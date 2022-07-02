package xa.pos289.exporters;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import xa.pos289.models.Variant;

public class VariantExporter {
	private List<Variant> listvar;
	
	public VariantExporter(List<Variant> listvar) {
		this.listvar = listvar;
	}
	
	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.blue);
		cell.setPadding(7);
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.yellow);
		
		cell.setPhrase(new Phrase("Category", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Initial", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Name", font));
		table.addCell(cell);
	}
	
	public void writeTableData(PdfPTable table) {
		for(Variant var:listvar) {
			table.addCell(String.valueOf(var.getCategory().getName()));
			table.addCell(String.valueOf(var.getInitial()));
			table.addCell(String.valueOf(var.getName()));
		}
	}
	
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.gray);
		
		Paragraph p = new Paragraph("List of Variants", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(p);
		
		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] {3.0f, 3.0f, 3.0f});
		table.setSpacingBefore(10);
		
		writeTableHeader(table);
		writeTableData(table);
		
		document.add(table);
		document.close();
	}
}
