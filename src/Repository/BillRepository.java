package repository;

import entity.Bill;

import java.util.List;

public interface BillRepository {
    List<Bill> findAll();

    Bill findById(int id);

    Bill save(Bill bill);

    void delete(int id);
}
