package dto;

import java.util.Date;
import java.util.List;

public class BillDTO {
    private int id;
    private List<BillOrderDTO> billOrderDTOList;
    private Date orderedTime;
    private double totalPrice;

    public BillDTO() {
    }

    public BillDTO(int id, List<BillOrderDTO> billOrderDTOList, Date orderedTime, double totalPrice) {
        this.id = id;
        this.billOrderDTOList = billOrderDTOList;
        this.orderedTime = orderedTime;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<BillOrderDTO> getBillOrderDTOList() {
        return billOrderDTOList;
    }

    public void setBillOrderDTOList(List<BillOrderDTO> billOrderDTOList) {
        this.billOrderDTOList = billOrderDTOList;
    }

    public Date getOrderedTime() {
        return orderedTime;
    }

    public void setOrderedTime(Date orderedTime) {
        this.orderedTime = orderedTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        double total = 0;
        for (BillOrderDTO billOrderDTO : this.billOrderDTOList) {
            total += billOrderDTO.getPrice() * billOrderDTO.getQuantity();
        }
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "BillDTO{" + "id=" + id + ", billOrderDTOList=" + billOrderDTOList + ", orderedTime=" + orderedTime + ", totalPrice=" + totalPrice + '}';
    }
}
