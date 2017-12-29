package com.hhdri.extrace;

import java.io.InputStream;
import java.util.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;

public class PriceTable {
    Document document;

    public List<EMoney> geteMonies() {
        return eMonies;
    }

    List<EMoney> eMonies = new ArrayList<EMoney>();

    public PriceTable(InputStream inputStream) throws Exception{
        document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
        fillEMonies();
    }

    private void fillEMonies() {
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("emoney");
        Dictionary<String, String> dictionary = new EMoney().getDict();
        Set<String> imps = new HashSet<String>(Collections.list(dictionary.keys()));
        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            Element element = (Element)node;
            if(imps.contains(element.getElementsByTagName("id").item(0).getTextContent())) {
                eMonies.add(new EMoney(element.getElementsByTagName("id").item(0).getTextContent(),
                        element.getElementsByTagName("buy_price").item(0).getTextContent(),
                        element.getElementsByTagName("sell_price").item(0).getTextContent(),
                        element.getElementsByTagName("reserve").item(0).getTextContent()));
            }
        }
    }
}
