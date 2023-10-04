package repository.impl;

import entity.BillOrder;
import repository.BillOrderRepository;

import java.util.List;

public class BillOrderRepositoryImpl implements BillOrderRepository {
    private static final String CSV_SEPARATOR = ",";
    private static final String FILE_HEADER = "ID,MENU_ID,BILL_ID,MENU_PRICE,QUANTITY";
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
