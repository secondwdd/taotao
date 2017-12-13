package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper tbItemMapper;
    @Override
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        //设置分页条件
        PageHelper.startPage(1,20);
        //创建封装查询条件
        TbItemExample example = new TbItemExample();
        //执行查询
        List<TbItem> tbItems = tbItemMapper.selectByExample(example);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        //封装分页查询信息
        PageInfo info = new PageInfo(tbItems);
        //总记录数
        long total = info.getTotal();
        result.setTotal(total);
        //每页显示的商品信息
        List list = info.getList();
        result.setRows(list);
        return result;
    }
}
