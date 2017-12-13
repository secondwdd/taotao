import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestPageHelper {
    @Test
    public void testPageHelper(){
        //获取工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
        PageHelper.startPage(1,30);
        TbItemExample example = new TbItemExample();
        List<TbItem> list1 = itemMapper.selectByExample(example);
        List<TbItem> list2 = itemMapper.selectByExample(example);
        System.out.println("打印的总数是："+list1.size());
        System.out.println("打印的总数是："+list2.size());

//        封装分页信息
        PageInfo<TbItem> info = new PageInfo<TbItem>(list1);
        System.out.println("总记录数："+info.getTotal());
        System.out.println("查询的列表行数："+info.getList().size());

    }
}
