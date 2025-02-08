package com.atguigu.lease.web.app.service.impl;

import com.atguigu.lease.model.entity.BrowsingHistory;
import com.atguigu.lease.web.app.mapper.BrowsingHistoryMapper;
import com.atguigu.lease.web.app.service.BrowsingHistoryService;
import com.atguigu.lease.web.app.vo.history.HistoryItemVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author liubo
 * @description 针对表【browsing_history(浏览历史)】的数据库操作Service实现
 * @createDate 2023-07-26 11:12:39
 */
@Service
@Slf4j
public class BrowsingHistoryServiceImpl extends ServiceImpl<BrowsingHistoryMapper, BrowsingHistory>
        implements BrowsingHistoryService {
    @Autowired
    private BrowsingHistoryMapper browsingHistoryMapper;

    @Override
    public IPage<HistoryItemVo> getHistoryPage(Page<HistoryItemVo> historyItemVoPage, Long userId) {
        return browsingHistoryMapper.getHistoryPage(historyItemVoPage, userId);
    }

    @Override
    @Async
    public void saveHistory(Long userId, Long id) {
        LambdaQueryWrapper<BrowsingHistory> browsingHistoryLambdaUpdateWrapper = new LambdaQueryWrapper<>();
        browsingHistoryLambdaUpdateWrapper.eq(BrowsingHistory::getUserId, userId);
        browsingHistoryLambdaUpdateWrapper.eq(BrowsingHistory::getRoomId, id);
        BrowsingHistory browsingHistory = browsingHistoryMapper.selectOne(browsingHistoryLambdaUpdateWrapper);
        if(browsingHistory!= null) {
            browsingHistory.setBrowseTime(new Date());
            browsingHistoryMapper.updateById(browsingHistory);
        }
        else {
            browsingHistory = new BrowsingHistory();
            browsingHistory.setUserId(userId);
            browsingHistory.setRoomId(id);
            browsingHistory.setCreateTime(new Date());
            browsingHistoryMapper.insert(browsingHistory);
        }


    }
}




