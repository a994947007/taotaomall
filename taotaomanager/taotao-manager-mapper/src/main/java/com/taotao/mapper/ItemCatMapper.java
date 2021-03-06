package com.taotao.mapper;

import com.taotao.bean.ItemCat;
import com.taotao.bean.ItemCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemCatMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    int countByExample(ItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    int deleteByExample(ItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    int insert(ItemCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    int insertSelective(ItemCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    List<ItemCat> selectByExample(ItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    ItemCat selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    int updateByExampleSelective(@Param("record") ItemCat record, @Param("example") ItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    int updateByExample(@Param("record") ItemCat record, @Param("example") ItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    int updateByPrimaryKeySelective(ItemCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    int updateByPrimaryKey(ItemCat record);
}