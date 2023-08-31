package com.example.hackstival.request.domain;

import com.example.hackstival.user.dto.SearchCondition;
import com.example.hackstival.user.dto.SortType;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.example.hackstival.common.Constant.parseFullDateTime;
import static com.example.hackstival.request.domain.QHelp.help;

@Repository
public class HelpRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public HelpRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Help.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Help> findHelpRequests(SearchCondition searchCondition) {

        return jpaQueryFactory
                .select(help)
                .from(help)
                .where(isRequestStatus())
                .where(afterStartTime(searchCondition.getStartTime()))
                .where(beforeEndTime(searchCondition.getEndTime()))
                .where(inRequestType(searchCondition.getRequestTypes()))
                .where(eqStartDongAddress(searchCondition.getDongName()))
                .orderBy(createOrderSpecifier(searchCondition.getSortType()))
                .fetch();
    }

    private BooleanExpression isRequestStatus() {
        return help.requestStatus.eq(RequestStatus.REQUEST);
    }

    private BooleanExpression afterStartTime(String time) {
        return time == null ? null : help.startTime.after(parseFullDateTime(time));
    }

    private BooleanExpression beforeEndTime(String time) {
        return time == null ? null : help.endTime.before(parseFullDateTime(time));

    }

    private BooleanExpression inRequestType(List<RequestType> requestTypes) {
        if (requestTypes == null) return null;
        return requestTypes.isEmpty() ? null : help.requestType.in(requestTypes);

    }

    private BooleanExpression eqStartDongAddress(String dongName) {
        return dongName == null ? null : help.moveInfo.startAddress.dongName.eq(dongName);
    }


    private OrderSpecifier[] createOrderSpecifier(SortType sortType) {
        List<OrderSpecifier> orderSpecifiers = new ArrayList<>();

        if (sortType == SortType.MONEY_DESC) orderSpecifiers.add(new OrderSpecifier(Order.DESC, help.money));

        orderSpecifiers.add(new OrderSpecifier(Order.DESC, help.id));

        return orderSpecifiers.toArray(new OrderSpecifier[orderSpecifiers.size()]);
    }

}
