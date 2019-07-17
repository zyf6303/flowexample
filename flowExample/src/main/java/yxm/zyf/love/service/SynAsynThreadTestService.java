package yxm.zyf.love.service;

import java.io.IOException;

import yxm.zyf.love.model.vo.ProdSerDTO;

public interface SynAsynThreadTestService {
    ProdSerDTO searchProd(String word);
    
    ProdSerDTO searchProdcb(String word);
    
    void dealBindInfo() throws IOException;
}
