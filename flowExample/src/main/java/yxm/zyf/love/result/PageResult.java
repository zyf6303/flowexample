package yxm.zyf.love.result;

/**
 * 
 * 类名: PageResult
 * 包名：  yxm.zyf.love.result
 * 作者：  Zhangyf
 * 时间：  2018年10月24日 下午6:15:57
 * 描述: TODO(请在此处详细描述类)
 * @since 1.0.0
 *
 * 修改历史 :
 * 1. [2018年10月24日]新建类 by Zhangyf
 *
 * @param <T>
 */
public class PageResult<T> extends Result {

    private Integer currentPage;
    private Integer totalPage;
    private T content;

    public PageResult<T> success(){
        this.success = true;
        return this;
    }

    public PageResult<T> content(T content) {
        this.content = content;
        return this;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
