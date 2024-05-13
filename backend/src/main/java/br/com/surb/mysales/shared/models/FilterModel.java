package br.com.surb.mysales.shared.models;

import static br.com.surb.mysales.shared.constants.ConstantFilterModel.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FilterModel implements Serializable {

  @Serial
  private static final long serialVersionUID = -5395498616284777444L;

  private Integer limit;
  private Integer page;
  private String sort;
  private String equalFilter;
  private String inFilter;
  private String dateFilter;

  public FilterModel() {
  }

  public FilterModel(Map<String, String> params) {
    this.limit = params.containsKey(LIMIT_KEY) ? Integer.valueOf(params.get(LIMIT_KEY)) : DEFAULT_LIMIT;
    this.page = params.containsKey(PAGE_KEY) ? Integer.valueOf(params.get(PAGE_KEY)) : DEFAULT_PAGE;
    this.sort = params.getOrDefault(SORT_KEY, DEFAULT_SORT);
    this.equalFilter = params.getOrDefault(EQUAL_KEY, DEFAULT_EQUAL);
    this.inFilter = params.getOrDefault(IN_KEY, DEFAULT_IN);
    this.dateFilter = params.containsKey(DATE_KEY) ? params.get(DATE_KEY) : DEFAULT_DATE;
  }

  public Pageable toSpringPageable(){
    List<Order> orders = getOrders();
    return PageRequest.of(page, limit, Sort.by(orders));
  }

  public List<DateFilterModel> getDateFilter(){
    List<DateFilterModel> filters = new ArrayList<>();

    if(dateFilter == null || dateFilter.trim().isEmpty()){
      return filters;
    }

    String[] params = dateFilter.split(";");

    for (String param: params){
      if(param.contains(":")){
        String[] elements = param.split(":");

        if(elements.length == 2){
          String column = elements[0];
          String[] parts = elements[1].split("to");

          if(parts.length == 2){
            String startDate = parts[0];
            String endDate = parts[1];
            filters.add(new DateFilterModel(column, startDate, endDate));
          }
        }
      }
    }
    return filters;
  }

  public List<InFilterModel> getInFilter(){
    List<InFilterModel> filters = new ArrayList<>();
    if(inFilter == null || inFilter.trim().isEmpty()){
      return filters;
    }
    String[] params = inFilter.split(";");

    for (String param: params){
      if(param.contains(":")){
        String[] elements = param.split(":");
        if(elements.length == 2){
          String column = elements[0];
          List<String> values = Arrays.asList(elements[1].split(","));
          filters.add(new InFilterModel(column, values, true));
        }
      }

      if(param.contains("~")){
        String[] elements = param.split("~");
        if(elements.length == 2){
          String column = elements[0];
          List<String> values = Arrays.asList(elements[1].split(","));
          filters.add(new InFilterModel(column, values, false));
        }
      }
    }
    return filters;
  }

  public List<EqualFilterModel> getEqualFilter(){
    List<EqualFilterModel> filters = new ArrayList<>();
    if(equalFilter == null || equalFilter.trim().isEmpty()){
      return filters;
    }
    String[] params = equalFilter.split(";");
    for (String param: params){
      if(param.contains(":")){
        String[] elements = param.split(":");
        if(elements.length == 2){
          String column = elements[0];
          String value = elements[1];
          filters.add(new EqualFilterModel(column, value, true));
        }
      }

      if(param.contains("~")){
        String[] elements = param.split("~");
        if(elements.length == 2){
          String column = elements[0];
          String value = elements[1];
          filters.add(new EqualFilterModel(column, value, false));
        }
      }
    }
    return filters;
  }

  private List<Order> getOrders(){
    List<Order> orders = new ArrayList<>();
    String[] properties = sort.split(",");
    for (String property: properties){
      if(!property.trim().isEmpty()){
        String column = "";
        if(property.startsWith("-")){
          column = property.replace("-", "").trim();
          orders.add(Order.desc(column));
        } else {
          column = property.trim();
          orders.add(Order.asc(column));
        }
      }
    }
    return orders;
  }

}
