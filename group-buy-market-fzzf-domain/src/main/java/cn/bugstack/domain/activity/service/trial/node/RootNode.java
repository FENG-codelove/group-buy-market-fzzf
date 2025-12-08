package cn.bugstack.domain.activity.service.trial.node;

import cn.bugstack.domain.activity.model.entity.MarketProductEntity;
import cn.bugstack.domain.activity.model.entity.TrialBalanceEntity;
import cn.bugstack.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import cn.bugstack.domain.activity.service.trial.factory.DefaultActivityStrategyFactory.DynamicContext;
import cn.bugstack.types.design.framework.tree.StrategyHandler;
import cn.bugstack.types.enums.ResponseCode;
import cn.bugstack.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class RootNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DynamicContext,TrialBalanceEntity> {
    @Resource
private SwitchRoot switchRoot;

    @Override
    public StrategyHandler<MarketProductEntity, DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DynamicContext dynamicContext) throws Exception {
        return switchRoot;
    }

    @Override
    protected TrialBalanceEntity doApply(MarketProductEntity requestParameter, DynamicContext dynamicContext) throws Exception {
        if (StringUtils.isBlank(requestParameter.getUserId())||
        StringUtils.isBlank(requestParameter.getGoodsId())||
        StringUtils.isBlank(requestParameter.getSource())||
        StringUtils.isBlank(requestParameter.getChannel())){
        throw  new AppException(ResponseCode.ILLEGAL_PARAMETER.getCode(),ResponseCode.ILLEGAL_PARAMETER.getInfo());
        }

        return router(requestParameter,dynamicContext);

    }
}
