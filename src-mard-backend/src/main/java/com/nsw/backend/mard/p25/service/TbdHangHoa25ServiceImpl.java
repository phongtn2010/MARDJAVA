package com.nsw.backend.mard.p25.service;


import com.google.common.cache.LoadingCache;
import com.nsw.backend.mard.p25.model.FilterHangHoa;
import com.nsw.backend.mard.p25.model.FilterResult;
import com.nsw.backend.mard.p25.model.FilterResultHH;
import com.nsw.backend.mard.p25.model.TbdHanghoa25;
import com.nsw.backend.mard.p25.repositories.TbdHangHoa25Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TbdHangHoa25ServiceImpl implements TbdHangHoa25Service{
    @Autowired
    private TbdHangHoa25Repository tbdHangHoa25Repository;
    private List<String> pendingProfiles;
    private LoadingCache<String, Boolean> pendingQueue;

    @Override
    public List<TbdHanghoa25> findByFiIdHS(Integer fiIdHS) {
        return tbdHangHoa25Repository.findByFiIdHS(fiIdHS);
    }

    @Override
    public void save(TbdHanghoa25 tbdHanghoa25) {
        tbdHangHoa25Repository.save(tbdHanghoa25);
    }

    @Override
    public TbdHanghoa25 findByFiIdProduct(Integer id) {
        return tbdHangHoa25Repository.findByFiIdProduct(id);
    }

    @Override
    public FilterResultHH searchHangHoa (FilterHangHoa filterHangHoa) {
        //filterForm.setFiLstNSWFileCode(findLstNSWFileCode(filterForm));
        return tbdHangHoa25Repository.searchHangHoa(filterHangHoa);
    }
    @Override
    public void saveAll(List<TbdHanghoa25> tbdHanghoa25s) {
        tbdHangHoa25Repository.save(tbdHanghoa25s);
    }

    @Override
    public List<TbdHanghoa25> findByFiTaxCodeAndFiTrangThaiHangHoa(String taxcode,Integer fiTrangThai) {
        return tbdHangHoa25Repository.findByFiTaxCodeAndFiTrangThaiHangHoa(taxcode, fiTrangThai);
    }
    //    @Override
//    public LoadingCache<String, Boolean> getSignPendingProfiles() {
//        if(pendingQueue == null){
//            pendingProfiles = new ArrayList<>();
//            this.pendingQueue = CacheBuilder.newBuilder()
//                    .maximumSize(10000)
//                    .expireAfterWrite(5, TimeUnit.MINUTES)
//                    .removalListener(removalNotification -> {
//                        if(removalNotification.wasEvicted()){
//                            //we should rollback automatically
//                            String nswFileCode = (String) removalNotification.getKey();
//                            rollbackFailedRequestUpdate(findByFiHSCode(nswFileCode));
//                        }
//                    })
//                    .build(new CacheLoader<String, Boolean>() {
//                        @Override
//                        public Boolean load(String s) throws Exception {
//                            return pendingProfiles.contains(s);
//                        }
//                    });
//        }
//        return pendingQueue;
//    }
//    @Override
//    public void rollbackFailedRequestUpdate(String nswFileCode) {
//        TbdHanghoa25 current = findByFiIdHS(nswFileCode);
//        if(Boolean.TRUE.equals(getSignPendingProfiles().getIfPresent(nswFileCode))) {
//            rollbackFailedRequestUpdate(current);
//        }
//    }

}