package br.com.surb.mysales.specifications;

import br.com.surb.mysales.builder.ExpressionBuilder;
import br.com.surb.mysales.entities.Product;
import br.com.surb.mysales.shared.constants.ConstantFilterModel;
import br.com.surb.mysales.shared.models.DateFilterModel;
import br.com.surb.mysales.shared.models.EqualFilterModel;
import br.com.surb.mysales.shared.models.InFilterModel;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import java.io.Serial;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductSpecification implements Serializable {

  @Serial
  private static final long serialVersionUID = 657099743252695661L;

  public static Specification<Product> equal(EqualFilterModel filterEqualModel){
    return (root, query, criteriaBuilder) -> {
      ExpressionBuilder<Product> expressionBuilder = new ExpressionBuilder<>(Product.class);
      Expression<Product> expression = expressionBuilder.getExpression(root, filterEqualModel.column());

      Predicate predicate = null;

      if(expression != null){
        predicate = (filterEqualModel.isEqual() ? criteriaBuilder.equal(expression, filterEqualModel.value()) :
          criteriaBuilder.notEqual(expression, filterEqualModel.value()));
      }
      return predicate;
    };
  }

  public static Specification<Product> in(InFilterModel inFilterModel){
    return (root, query, criteriaBuilder) -> {
      ExpressionBuilder<Product> expressionBuilder = new ExpressionBuilder<>(Product.class);
      Expression<Product> expression = expressionBuilder.getExpression(root, inFilterModel.column());

      Predicate predicate = null;

      if(expression != null){

        predicate = inFilterModel.isIn() ? expression.as(String.class).in(inFilterModel.values())
          : expression.as(String.class).in(inFilterModel.values()).not();

      }
      return predicate;
    };
  }

  public static Specification<Product> dateBetween(DateFilterModel dateFilterModel){
    return (root, query, criteriaBuilder) -> {
      SimpleDateFormat formatter = new SimpleDateFormat(ConstantFilterModel.DATE_FORMAT);
      System.out.println("Formatter => " + formatter);
      try {
        Date startDate = formatter.parse(dateFilterModel.startDate());
        System.out.println("Start date => " + startDate);
        Date endDate = formatter.parse(dateFilterModel.endDate());
        System.out.println("End date => " + endDate);

        ExpressionBuilder<Product> expressionBuilder = new ExpressionBuilder<>(Product.class);
        Expression<Product> expression = expressionBuilder.getExpression(root, dateFilterModel.column());

        Expression<Date> dateExpression = criteriaBuilder.function("DATE", Date.class, expression);
        System.out.println(dateExpression);
        return criteriaBuilder.between(dateExpression, startDate, endDate);

      }catch (Exception e){
        e.printStackTrace();
        return null;
      }
    };
  }
}
