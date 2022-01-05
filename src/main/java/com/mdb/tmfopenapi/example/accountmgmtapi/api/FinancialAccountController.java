package com.mdb.tmfopenapi.example.accountmgmtapi.api;

import java.util.List;

import javax.validation.Valid;

import com.mdb.tmfopenapi.example.accountmgmtapi.dao.FinancialAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mdb.tmfopenapi.example.accountmgmtapi.api.FinancialAccountApi;
import com.mdb.tmfopenapi.example.accountmgmtapi.api.model.FinancialAccount;
import com.mdb.tmfopenapi.example.accountmgmtapi.api.model.FinancialAccountCreate;
import com.mdb.tmfopenapi.example.accountmgmtapi.api.model.FinancialAccountUpdate;


@Controller
@RequestMapping("/tmf-api/accountManagement/v4")
public class FinancialAccountController implements FinancialAccountApi {

    @Autowired
    private FinancialAccountDao dao;

    @Override
    @PostMapping("/financialAccount")
    public ResponseEntity<FinancialAccount> createFinancialAccount(@Valid FinancialAccountCreate financialAccount) {
        var account = dao.createFinancialAccount(financialAccount);
        return ResponseEntity.ok(account);
    }

    @Override
    @DeleteMapping("/financialAccount")
    public ResponseEntity<Void> deleteFinancialAccount(String id) {
        dao.deleteFinancialAccount(id);
        return ResponseEntity.ok(null);
    }

    @Override
    @GetMapping("/financialAccount")
    public ResponseEntity<List<FinancialAccount>> listFinancialAccount(@Valid String fields, @Valid Integer offset,
                                                                       @Valid Integer limit) {

        var accounts = dao.getFinancialAccounts(fields, offset, limit);
        return ResponseEntity.ok(accounts);
    }

    @Override
    @PatchMapping("/financialAccount/{id}")
    public ResponseEntity<FinancialAccount> patchFinancialAccount(@PathVariable String id,
                                                                  @Valid FinancialAccountUpdate financialAccount) {

        var updatedAccount = dao.updateFinancialAccount(id, financialAccount);
        return ResponseEntity.ok(updatedAccount);
    }

    @Override
    @GetMapping("/financialAccount/{id}")
    public ResponseEntity<FinancialAccount> retrieveFinancialAccount(@PathVariable String id, @Valid String fields) {
        var account = dao.getFinancialAccount(id, fields);
        return ResponseEntity.ok(account);
    }

}
