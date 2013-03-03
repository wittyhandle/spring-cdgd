package com.mike.domain;

import com.mike.config.PersistenceConfig;
import com.mike.config.WebConfig;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * User: mike
 * Date: 2/11/13
 * Time: 8:42 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class ProjectTest
{
    @Autowired
    private Validator validator;

    @Test
    public void testEquality() throws Exception
    {
        Project one = new Project();
        one.setId(100l);
        one.setName("One");
        one.setDescription("One Description");

        Project two = new Project();
        two.setId(100l);
        two.setName("One");
        two.setDescription("One Description");

        assertTrue(one.equals(two));

        assertFalse(one.equals(new Project()));
        assertFalse(one.equals(null));
        assertFalse(one.equals(new String()));
    }

    @Test
    public void testValidation() throws Exception
    {
        Project project = new Project();

        Set<ConstraintViolation<Project>> errors = validator.validate(project);
        assertEquals(2, errors.size());

        Map<String, String> errorsByCode = convertConstraintsToHash(errors);

        assertEquals("Please enter a project name.", errorsByCode.get("{project.name.empty}"));
        assertEquals("Please enter a project description.", errorsByCode.get("{project.description.empty}"));
    }

    @Configuration
    static class ContextConfiguration
    {
        @Bean(name = "messageSource")
        public MessageSource configureMessageSource()
        {
            ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
            messageSource.setBasename("ValidationMessages");
            messageSource.setCacheSeconds(5);
            return messageSource;
        }

        @Bean
        public org.springframework.validation.Validator getValidator()
        {
            LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
            localValidatorFactoryBean.setValidationMessageSource(configureMessageSource());

            return localValidatorFactoryBean;
        }
    }

    private Map<String, String> convertConstraintsToHash(Set<ConstraintViolation<Project>> errors)
    {
        Iterator<ConstraintViolation<Project>> errorItr = errors.iterator();
        Map<String, String> errorsByCode = new HashMap<String, String>();

        while (errorItr.hasNext())
        {
            ConstraintViolation<Project> error = errorItr.next();
            errorsByCode.put(error.getMessageTemplate(), error.getMessage());
        }

        return errorsByCode;
    }

}
