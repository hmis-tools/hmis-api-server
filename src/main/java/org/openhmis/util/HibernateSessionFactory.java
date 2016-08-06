/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.InitialContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Configures and provides access to Hibernate sessions, tied to the
 * current thread of execution.  Follows the Thread Local Session
 * pattern, see {@link http://hibernate.org/42.html }.
 */
public class HibernateSessionFactory {

    /** 
     * Location of hibernate.cfg.xml file.
     * Location should be on the classpath as Hibernate uses  
     * #resourceAsStream style lookup for its configuration file. 
     * The default classpath location of the hibernate config file is 
     * in the default package. Use #setConfigFile() to update 
     * the location of the configuration file for the current session.   
     */
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    private HibernateSessionFactory() {
    }

    /**
     * Returns the ThreadLocal Session instance.  Lazy initialize
     * the <code>SessionFactory</code> if needed.
     *
     *  @return Session
     *  @throws HibernateException
     */
    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();

        // If an open session doesn't already exist, create one
        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            session = (sessionFactory != null) ? sessionFactory.openSession()
                : null;
            threadLocal.set(session);
        }

        return session;
    }

	/**
     *  Rebuild hibernate session factory
     *
     */
	public static void rebuildSessionFactory() {
		try {
	        Configuration configuration = new Configuration();
	
	        // Define the class mappings
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpMedicalAssistance.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpProjectContinuum.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpProjectInventory.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpProjectSite.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpEnrollment.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpPhysicalDisability.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.SchemaVersion.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpExit.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpReferral.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.PathClientVeteranInfo.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpContact.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpMentalHealthProblem.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpHealthInsurance.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpProject.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpChronicHealthCondition.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpHivAidsStatus.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpService.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpOrganization.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpDomesticAbuse.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.PathClientProgram.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpProjectFunder.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.PathClient.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpFinancialAssistance.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpSubstanceAbuse.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpNonCashBenefit.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpIncomeSource.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.PathClientRace.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpDevelopmentalDisability.class);
                configuration.addAnnotatedClass(org.openhmis.domain.TmpTokenCache.class);
	        configuration.addAnnotatedClass(org.openhmis.domain.TmpUser.class);

	        // Load the application properties based on the current context
	        ApplicationPropertyUtil propertyUtil = new ApplicationPropertyUtil();
			Properties properties = propertyUtil.getProperties();

			// Define the connection settings from the properties
	        configuration.setProperty("hibernate.dialect", properties.getProperty("hibernate.dialect"));
	        configuration.setProperty("hibernate.connection.url", properties.getProperty("hibernate.connection.url"));
	        configuration.setProperty("hibernate.connection.username", properties.getProperty("hibernate.connection.username"));
	        configuration.setProperty("hibernate.connection.password", properties.getProperty("hibernate.connection.password"));
	        configuration.setProperty("hibernate.connection.driver_class", properties.getProperty("hibernate.connection.driver_class"));
	
	        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	                configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
     *  Close the single hibernate session instance.
     *
     *  @throws HibernateException
     */
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }

	/**
     *  return session factory
     *
     */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
