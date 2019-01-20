import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JasperReportFill2 {
   @SuppressWarnings("unchecked")
   public static void main(String[] args) {
      String sourceFileName ="src/main/resources/report/reports.jasper";
      DataBeanList DataBeanList = new DataBeanList();
      ArrayList<DataBean> dataList = DataBeanList.getDataBeanList();

      JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);

      Map parameters = new HashMap();
      try {
         JasperPrint jasperPrint = JasperFillManager.fillReport(
         sourceFileName,
         parameters,
         beanColDataSource);
         JasperExportManager.exportReportToPdfFile(jasperPrint,"src/main/resources/report/001.pdf");
         
      } catch (JRException e) {
         e.printStackTrace();
      }
   }
}