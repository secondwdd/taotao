package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;

public interface ItemService {
    /**
     * 分页查询商品列表
     * @param page
     * @param rows
     * @return
     */
    EasyUIDataGridResult getItemList(Integer page,Integer rows);
}
