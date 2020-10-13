package com.dhruba.java.interfaceandabstraction.interfaces.csv;

import static com.dhruba.java.interfaceandabstraction.interfaces.ClientEngagementRepository.NO_ID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.junit.After;
import org.junit.Test;

import com.dhruba.java.interfaceandabstraction.interfaces.ClientEngagement;
import com.dhruba.java.interfaceandabstraction.interfaces.Query;

public class CsvClientEngagementRepositoryTest
{
    private static final String PLURALSIGHT = "Pluralsight";

    private File file = File.createTempFile("database", "csv");
    private CsvClientEngagementRepository repository = new CsvClientEngagementRepository(file.getAbsolutePath());
    private ClientEngagement engagement = new ClientEngagement(PLURALSIGHT, 10);

    public CsvClientEngagementRepositoryTest() throws IOException
    {
    }

    @After
    public void tearDown() throws Exception
    {
        repository.close();
    }

    @Test
    public void shouldAddClientEngagement() throws Exception
    {
        repository.add(engagement);

        assertNotEquals(NO_ID, engagement.getId());
    }

    @Test
    public void shouldRemoveClientEngagement() throws Exception
    {
        repository.add(engagement);

        repository.remove(engagement);

        assertEquals(NO_ID, engagement.getId());
    }

    @Test
    public void shouldFindRelevantClientEngagements() throws Exception
    {
        repository.add(engagement);
        repository.add(new ClientEngagement("Foo", 20));
        repository.add(new ClientEngagement(PLURALSIGHT, 20));

        final Iterator<ClientEngagement> engagements =
                repository.find(new Query().atLeastHoursWorked(15).client(PLURALSIGHT)).iterator();

        assertTrue(engagements.hasNext());

        final ClientEngagement result = engagements.next();
        assertEquals(PLURALSIGHT, result.getClient());
        assertEquals(20, result.getHoursWorked());

        assertFalse(engagements.hasNext());
    }

}
