package com.nsw.backend.mard.p25.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.nsw.backend.mard.p25.model.TbdHanghoa25;
import com.nsw.backend.mard.p25.repositories.TbdHangHoa25Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class TbdHangHoa25ServiceImpl implements TbdHangHoa25Service{
    @Autowired
    private TbdHangHoa25Repository tbdHangHoa25Repository;
//    private List<String> pendingProfiles;
//    private LoadingCache<String, Boolean> pendingQueue;

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
    public void saveAll(List<TbdHanghoa25> tbdHanghoa25s) {
        tbdHangHoa25Repository.save(tbdHanghoa25s);
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
//    public void rollbackFailedRequestUpdate(TbdHanghoa25 result) {
//        TbdHanghoa25 parent = tbdHangHoa25Repository.findOne(result.getFiIdHS());
//        parent.setFiActive(true);
//
//        tbdHangHoa25Repository.save(parent);
//        tbdHangHoa25Repository.delete(result.getFiIdHS());
//        getSignPendingProfiles().invalidate(result.getFiNSWFileCode());
//    }
}
