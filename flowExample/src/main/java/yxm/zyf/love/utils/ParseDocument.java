package yxm.zyf.love.utils;

import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import yxm.zyf.love.entity.message.Document;

/**
 * Created by tjz on 2016/5/12.
 */
public class ParseDocument {

    public static Document parse(String data) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(data, Document.class);
    }
}
