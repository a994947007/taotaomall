package com.taotao.mapper;

import com.taotao.bean.ItemDesc;
import com.taotao.bean.ItemDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemDescMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    int countByExample(ItemDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    int deleteByExample(ItemDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    int deleteByPrimaryKey(Long itemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    int insert(ItemDesc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    int insertSelective(ItemDesc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    List<ItemDesc> selectByExampleWithBLOBs(ItemDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    List<ItemDesc> selectByExample(ItemDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    ItemDesc selectByPrimaryKey(Long itemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    int updateByExampleSelective(@Param("record") ItemDesc record, @Param("example") ItemDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") ItemDesc record, @Param("example") ItemDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    int updateByExample(@Param("record") ItemDesc record, @Param("example") ItemDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    int updateByPrimaryKeySelective(ItemDesc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(ItemDesc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Apr 03 22:25:03 CST 2020
     */
    int updateByPrimaryKey(ItemDesc record);
}