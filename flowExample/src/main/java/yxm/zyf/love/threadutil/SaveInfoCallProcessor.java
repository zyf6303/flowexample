package yxm.zyf.love.threadutil;

import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

import yxm.zyf.love.entity.ProdDO;
import yxm.zyf.love.mapper.ProdMapper;
import yxm.zyf.love.utils.LoggerUtil;

public class SaveInfoCallProcessor implements Callable<String> {//有返回值的线程执行
    private static final Logger logger = Logger.getLogger(SaveInfoCallProcessor.class);

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
    public String call() throws Exception {
        LoggerUtil.info(logger, "线程:{0},执行", Thread.currentThread().getName());
        prodMapper.insert(prodDo);
        return Thread.currentThread().getName()+"执行成功";
    }

}
