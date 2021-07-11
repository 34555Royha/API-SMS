package com.sms.demo.Repositories;

import java.util.List;

import com.sms.demo.Model.Payment.Payment;
import com.sms.demo.Model.Payment.PaymentCreate;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository {
    
    @Select("SELECT * FROM `tbl_Payment`")
    public List<Payment> List();

    @Select("SELECT * FROM `tbl_Payment` WHERE `Id` = #{id}")
    public Payment getById(String id);

    @Delete("DELETE FROM `tbl_Payment` WHERE `Id` = #{id}")
    public Boolean Delete(String id);

    @Insert("INSERT INTO `tbl_Payment`(`InvoiceID`, `Amount`, `Discount`, `Paid`, `Remain`) VALUES (#{InvoiceID},#{Amount},#{Discount},#{Paid},#{Remain})")
    public Boolean Create(PaymentCreate paymentCreate);

    @Update("UPDATE `tbl_Payment` SET `InvoiceID`=#{InvoiceID},`Amount`=#{Amount},`Discount`=#{Discount},`Paid`=#{Paid},`Remain`=#{Remain} WHERE `Id` = #{Id}")
    public Boolean Update(Payment payment);

    @Select("SELECT * FROM `tbl_Payment` WHERE InvoiceID  = #{InvoiceID} ")
    public List<Payment> Search(String InvoiceID);

    @Select("SELECT `Id` FROM `tbl_Invoice`")
    public List<String> invoice();
}
