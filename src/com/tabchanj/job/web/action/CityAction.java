package com.tabchanj.job.web.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.tabchanj.job.domain.City;
import com.tabchanj.job.service.ICityService;

public class CityAction  extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private City city;
	private Long id;
	private List<City> citys;

	private ICityService service;




	public String list() {
		this.citys = this.service.listCitys();
		return "list";
	}

	public String edit() {
		if (id != null)
			this.city = this.service.getCity(id);
		return INPUT;
	}

	public String update() {
		if (this.city.getId() != null)
			this.service.updateCity(city);
		else
			this.service.saveCity(city);
		return SUCCESS;
	}

	public String delete() {
		if (this.id != null) {
			this.service.deleteCity(id);
		}
		return SUCCESS;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City City) {
		this.city = City;
	}

	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setService(ICityService service) {
		this.service = service;
	}
	
}
