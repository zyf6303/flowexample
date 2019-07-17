package yxm.zyf.love.threadutil;

import org.apache.log4j.Logger;

import yxm.zyf.love.entity.ProdDO;
import yxm.zyf.love.mapper.ProdMapper;
import yxm.zyf.love.utils.LoggerUtil;

public class SaveInfoProcessor implements Runnable{//无返回值的线程执行
    private static final Logger logger =Logger.getLogger(SaveInfoProcessor.class);
    
    private ProdDO prodDo;
    
    private ProdMapper prodMapper;
    
    public ProdDO getProdDo() {
        return prodDo;
    }

    public void setProdDo(ProdDO prodDo) {
        this.prodDo = prodDo;
    }

    public ProdMapper getProdMapper() {
        return prodMapper;
    }

    public void setProdMapper(ProdMapper prodMapper) {
        this.prodMapper = prodMapper;
    }



    @Override
    public void run() {
        LoggerUtil.info(logger, "线程：{0},执行",Thread.currentThread().getName());
        prodMapper.insert(prodDo);
        
    }
    
    
}
