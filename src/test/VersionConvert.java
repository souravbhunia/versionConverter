package test;


import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class VersionConvert
{
  public static void main(String[] args)
    throws TransformerFactoryConfigurationError, ParserConfigurationException, SAXException, IOException, TransformerException
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the directory where to search ");
    
    File folder = new File(scan.next());
    File[] listOfFiles = folder.listFiles();
    String dir = null;
    for (int i = 0; i < listOfFiles.length; i++)
    {
//      if (listOfFiles[i].isFile())
//      {
//        System.out.println("File " + listOfFiles[i].getName());
//      }
    	if (listOfFiles[i].isDirectory())
      {
        dir = listOfFiles[i].getAbsolutePath();
        System.out.println("Directory " + listOfFiles[i].getAbsolutePath());
      }
      File directoryPath = new File(dir);
      
      File[] filesList = directoryPath.listFiles();
      
      String filepath = null;
      File[] arrayOfFile1;
      int j = (arrayOfFile1 = filesList).length;
      for (int m = 0; m < j; m++)
      {
        File file = arrayOfFile1[m];
        if (file.getName().equalsIgnoreCase("pom.xml"))
        {
          filepath = file.getAbsolutePath();
          System.out.println("Absolute path of pom.xml is: " + file.getAbsolutePath());
        }
      }
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      
      Document doc = builder.parse(filepath);
      
      doc.getDocumentElement().normalize();
      
      XPath xPath = XPathFactory.newInstance().newXPath();
      
      String expression = "/project/properties/app.runtime";
      NodeList nodeList = null;
      try
      {
        nodeList = (NodeList)xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
      }
      catch (XPathExpressionException e)
      {
        e.printStackTrace();
      }
      for (int l = 0;l < nodeList.getLength();l++)
      {
        Node nNode = nodeList.item(l);
        System.out.println("\nCurrent Element :" + nNode.getNodeName());
       //app.runtime
        if (nNode.getNodeType() == 1)
        {
          Element eElement = (Element)nNode;
          
          System.out.println("app.runtime version  : " + eElement.getTextContent());
          
          eElement.setTextContent("4.4.4-20211222");
          System.out.println("After replacement app.runtime version is : " + eElement.getTextContent());
          
          System.out.println("REPLACING DATA___________________");
          
          Transformer xformer = TransformerFactory.newInstance().newTransformer();
          xformer.transform(new DOMSource(doc), new StreamResult(filepath));
          System.out.println("END_________runtime version____________________END");
        }
      }
      String expression1 = "/project/dependencies/dependency";
      NodeList nodeList1 = null;
      try
      {
        nodeList1 = (NodeList)xPath.compile(expression1).evaluate(doc, XPathConstants.NODESET);
      }
      catch (XPathExpressionException e)
      {
        e.printStackTrace();
      }
      for (int k = 0; k < nodeList1.getLength(); k++)
      {
        Node nNode = nodeList1.item(k);
        if (nNode.getNodeType() == 1)
        {
          Element eElement = (Element)nNode;
          String mule_code = eElement.getElementsByTagName("artifactId").item(0).getTextContent();
         //apikit
          if (mule_code.equals("mule-apikit-module"))
          {
            System.out.println("version of mule-apikit-module : " + 
              eElement.getElementsByTagName("version").item(0).getTextContent());
            
            eElement.getElementsByTagName("version").item(0).setTextContent("1.9.1");
            System.out.println("REPLACING DATA___________________");
            System.out.println("After replacing version of mule-apikit-module: " + 
              eElement.getElementsByTagName("version").item(0).getTextContent());
            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.transform(new DOMSource(doc), new StreamResult(filepath));
            System.out.println("END_____________________________END");
          }
          //http connector
          if (mule_code.equals("mule-http-connector"))
          {
            System.out.println("version of mule-http-connector : " + 
              eElement.getElementsByTagName("version").item(0).getTextContent());
            
            eElement.getElementsByTagName("version").item(0).setTextContent("1.7.3");
            System.out.println("REPLACING DATA___________________");
            System.out.println("After replacing version of mule-http-connector : " + 
              eElement.getElementsByTagName("version").item(0).getTextContent());
            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.transform(new DOMSource(doc), new StreamResult(filepath));
            System.out.println("END_____________________________END");
          }
          //munit runner
          if (mule_code.equals("munit-runner"))
          {
            System.out.println("version of munit runner : " + 
              eElement.getElementsByTagName("version").item(0).getTextContent());
            
            eElement.getElementsByTagName("version").item(0).setTextContent("2.3.16");
            System.out.println("REPLACING DATA___________________");
            System.out.println("After replacing version of munit runner : " + 
              eElement.getElementsByTagName("version").item(0).getTextContent());
            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.transform(new DOMSource(doc), new StreamResult(filepath));
            System.out.println("END_____________________________END");
          }
          //munit tools
          if (mule_code.equals("munit-tools"))
          {
            System.out.println("version of munit-tools : " + 
              eElement.getElementsByTagName("version").item(0).getTextContent());
            
            eElement.getElementsByTagName("version").item(0).setTextContent("2.3.16");
            System.out.println("REPLACING DATA___________________");
            System.out.println("After replacing version of munit-tools : " + 
              eElement.getElementsByTagName("version").item(0).getTextContent());
            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.transform(new DOMSource(doc), new StreamResult(filepath));
            System.out.println("END_____________________________END");
          }
          //db
          if (mule_code.equals("mule-db-connector"))
          {
            System.out.println("version of mule-db-connector : " + 
              eElement.getElementsByTagName("version").item(0).getTextContent());
            
            eElement.getElementsByTagName("version").item(0).setTextContent("1.14.1");
            System.out.println("REPLACING DATA___________________");
            System.out.println("After replacing version of mule-db-connector : " + 
              eElement.getElementsByTagName("version").item(0).getTextContent());
            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.transform(new DOMSource(doc), new StreamResult(filepath));
            System.out.println("END_____________________________END");
          }
          // mq
          if (mule_code.equals("anypoint-mq-connector"))
          {
            System.out.println("version of anypoint-mq-connector : " + 
              eElement.getElementsByTagName("version").item(0).getTextContent());
            
            eElement.getElementsByTagName("version").item(0).setTextContent("4.0.3");
            System.out.println("REPLACING DATA___________________");
            System.out.println("After replacing version of anypoint-mq-connector: " + 
              eElement.getElementsByTagName("version").item(0).getTextContent());
            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.transform(new DOMSource(doc), new StreamResult(filepath));
            System.out.println("END_____________________________END");
          }
          //sftp
          if (mule_code.equals("mule-sftp-connector"))
          {
            System.out.println("version ofmule-sftp-connector : " + 
              eElement.getElementsByTagName("version").item(0).getTextContent());
            
            eElement.getElementsByTagName("version").item(0).setTextContent("1.6.1");
            System.out.println("REPLACING DATA___________________");
            System.out.println("After replacing version of mule-sftp-connector : " + 
              eElement.getElementsByTagName("version").item(0).getTextContent());
            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.transform(new DOMSource(doc), new StreamResult(filepath));
            System.out.println("END_____________________________END");
          }
        }
      }
      System.out.println("Process end ----");
    }
  }
}