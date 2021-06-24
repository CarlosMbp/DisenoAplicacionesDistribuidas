package IngerGYM;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager; 
import org.springframework.cache.annotation.EnableCaching; 
import org.springframework.context.annotation.Bean; 
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession; 

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;

import org.apache.commons.logging.Log;


@EnableCaching
@SpringBootApplication
@EnableHazelcastHttpSession
public class Application {

	private static final Log LOG = LogFactory.getLog(Application.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
    @Bean
    public Config config() {

        Config config = new Config();

        JoinConfig joinConfig = config.getNetworkConfig().getJoin();

        joinConfig.getMulticastConfig().setEnabled(true);

		return config;
    }

    
 
    @Bean
    public HazelcastInstance hazelcastInstance(Config hazelCastConfig) {
        return Hazelcast.newHazelcastInstance(hazelCastConfig);
    }
 
    @Bean
    public CacheManager cacheManager(HazelcastInstance hazelcastInstance) {
        return new HazelcastCacheManager(hazelcastInstance);
    }
}
