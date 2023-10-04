package repository;

import entity.BillOrder;

import java.util.List;

public interface BillOrderRepository {
    List<BillOrder> findAll();

    BillOrder findById(int id);

    BillOrder save(BillOrder billOrder);

    BillOrder update(BillOrder billOrder);

    void delete(int id);
}
