package com.roger.shop.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.roger.shop.service.AccountService;
import com.roger.shop.service.CategoryService;
import com.roger.shop.service.ProductService;
import com.roger.shop.upload.FileImage;
import com.roger.shop.upload.FileUpload;

/**
 * Struts执行流程 先创建Action 在调用拦截器，拦截器访问成功，在执行Action方法
 * 
 * 在项目启动时Struts2的过滤器，已经把相应的内置对象，以及内置对象对应的Map存储到了ActionContext和值栈中去了 如果实现了
 * ****Aware接口，就会从ActionContext中获取相应的Map进行传入，实现的拦截器为:servletConfig
 * 
 * @author Roger.Li
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@Controller
@Scope(value = "prototype")
public class BaseAction<T> extends ActionSupport
		implements RequestAware, SessionAware, ApplicationAware, ModelDriven<T> {

	private static final long serialVersionUID = 6155869410856217123L;

	protected static final String TOTAL = "total";
	protected static final String ROWS = "rows";
	
	@Resource
	protected CategoryService categoryService;
	
	@Resource
	protected AccountService accountService;
	
	@Resource
	protected ProductService productService;
	
	@Resource
	protected FileUpload fileUpload;
	
	protected Map<String, Object> request;

	protected Map<String, Object> session;

	protected Map<String, Object> application;

	protected T model;
	
	protected Integer page;
	
	protected Integer rows;
	
	protected List<T> jsonList;

	protected Map<String,Object> pageMap = null;
	
	protected FileImage fileImage;
	
	protected String ids;
	
	protected InputStream inputStream;
	
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Override
	public T getModel() {
		try {
			ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class clazz = (Class) parameterizedType.getActualTypeArguments()[0];
			model = (T) clazz.newInstance();
			return model;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public List<T> getJsonList() {
		return jsonList;
	}

	public Map<String, Object> getPageMap() {
		return pageMap;
	}

	public FileImage getFileImage() {
		return fileImage;
	}

	public void setFileImage(FileImage fileImage) {
		this.fileImage = fileImage;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public InputStream getInputStream() {
		return inputStream;
	}
	
}
