package com.code.deploy.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.code.deploy.entity.CodeDeploy;


@Repository
public class CodeDeployDAO extends BaseDAO<CodeDeploy> {
	private static final Log log = LogFactory.getLog(CodeDeployDAO.class);

	public List<CodeDeploy> findByLocationId(String ID) {
		System.out.println(ID);
		List<CodeDeploy> instances = null;
		
		
		List<String> listParameter = new ArrayList<>();
		listParameter=Arrays.asList(ID.split("\\s*,\\s*"));
		


		try {
			instances = entityManager.createQuery("select n from CodeDeploy n where n.ID IN (:listParameter) ", CodeDeploy.class).setParameter("listParameter", listParameter).getResultList();
			 System.out.println(instances+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.info("get Location successful");
		} catch (RuntimeException re) {

			log.error("get Location failed", re);
            System.out.println(re+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}
		return instances;
	}
	
}
