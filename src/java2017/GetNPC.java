package java2017;

import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  
  
import org.w3c.dom.Document;  
import org.w3c.dom.Element;  
import org.w3c.dom.Node;  
import org.w3c.dom.NodeList;  
  
public class GetNPC {  
    static HashMap<Integer, NPC> map = new HashMap<Integer, NPC>();  
      
    public static void getnpc(int num){  

        String numstr = String.valueOf(num);  
        String path = "npc\\npc"+numstr+".xml";  
        try{   
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
            DocumentBuilder builder = factory.newDocumentBuilder();  
  
            Document doc = builder.parse(path);
            setNPC(doc,num);  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
          
    }  
    
    

    public static void setNPC(Node doc,int num){  
        String name = "";  
        String talk=""; 
        String talk1="";
       
        
        Node node = (Node) doc.getFirstChild();  
        System.out.println(node.getNodeName());  
        NodeList nodes = node.getChildNodes();
        for(int i=0;i<nodes.getLength();i++){  
            Node n = nodes.item(i);  
            String str = n.getNodeName();  
            if(n instanceof Element){  
                if(str.equals("name")){  
                    name = n.getTextContent();  
                }else if(str.equals("talk"))
                	talk=n.getTextContent();
               
         
                else if(str.equals("talk1"))
                {
                	talk1=n.getTextContent();
                }
                	
          }  
        }  
        NPC npc = new NPC(name, talk, talk1);  

        map.put(num, npc);  
        System.out.println(npc.name);  
    }  
}  