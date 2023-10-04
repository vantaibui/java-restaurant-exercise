package repository.impl;

import entity.BillOrder;
import repository.BillOrderRepository;

import java.util.List;

public class BillRepositoryImpl implements BillOrderRepository {
    private static final String CSV_SEPARATOR = ",";
    private static final String FILE_HEADER = "ID,ORDER_TIME,STATUS";
    @Override
    public List<BillOrder> findAll() {
        return null;
    }

    @Override
    public BillOrder findById(int id) {
        return null;
    }

    @Override
    public BillOrder save(BillOrder billOrder) {
        return null;
    }

    @Override
    public BillOrder update(BillOrder billOrder) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
