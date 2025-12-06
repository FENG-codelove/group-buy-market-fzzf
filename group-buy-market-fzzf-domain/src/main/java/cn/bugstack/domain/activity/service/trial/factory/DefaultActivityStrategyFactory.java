package cn.bugstack.domain.activity.service.trial.factory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class DefaultActivityStrategyFactory {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public  static  class DynamicContext{

    }
}
