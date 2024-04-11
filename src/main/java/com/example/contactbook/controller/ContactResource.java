package com.example.contactbook.controller;


import com.example.contactbook.model.Contact;
import com.example.contactbook.model.NifiMock;
import com.example.contactbook.profiletest.MyBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@RestController("contact-controller")
@RequestMapping("/api/contacts")
public class ContactResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactResource.class);

    private Map<Integer, Contact> contactMap = new ConcurrentHashMap();
    private AtomicInteger idCounter = new AtomicInteger(1);
    private Map<Integer, NifiMock> nifiMap = new ConcurrentHashMap();
    private AtomicInteger nifiCounter = new AtomicInteger(1);

    private final MyBean bean;

    @Autowired
    public ContactResource(MyBean bean) {
        this.bean = bean;
        bean.printMessage();

        Contact contact = new Contact();
        contact.setId(-1);
        contact.setFirstName("Yeda");
        contact.setLastName("Anna");
        String company = "awara-pagal-diwana.com";
        contact.setCompany(company);
        contactMap.put(contact.getId(), contact);

        contact = new Contact();
        contact.setId(-2);
        contact.setFirstName("Chota");
        contact.setLastName("Chattri");
        contact.setCompany(company);

        contactMap.put(contact.getId(), contact);
    }

    @GetMapping
    @ResponseBody
    public Collection<Contact> getContacts() {
        return contactMap.values();
    }

    @GetMapping("/{contact-id}")
    @ResponseBody
    public Contact getContact(@NonNull @PathVariable("contact-id") int id) {
        System.out.println("Got request for contact with id " + id);
        Contact contact = contactMap.get(id);
        if (contact != null) System.out.println("Returning contact: " + contact.toString());
        else System.out.println("Contact not found for id: " + id);

        return contact;
    }

    @PostMapping
    @ResponseBody
    public Contact addContact(@RequestBody Contact contact) {
        int id = idCounter.incrementAndGet();
        contact.setId(id);

        System.out.println("Adding contact: " + contact.toString());
        contactMap.put(id, contact);

        return contact;
    }

    @GetMapping("/names-by-ids")
    @ResponseBody
    public List<HashMap<Integer, String>> namesForIds(@RequestParam Integer[] ids) {
        ArrayList<HashMap<Integer, String>> values = new ArrayList<>();
        for (Integer id : ids) {
            System.out.println(id);
            HashMap<Integer, String> map = new HashMap<>();
            map.put(id, "Name" + id);

            values.add(map);
        }
        return values;
    }

    @PostMapping("/nifi-mock")
    @ResponseBody
    public NifiMock mockNifi(@RequestBody NifiMock mock) {
        int id = idCounter.incrementAndGet();
        if (id % 3 == 0) {
            throw new RuntimeException("Invalid request...");
        }

        mock.setId(id);

        System.out.println("Adding mock: " + mock.toString());
        nifiMap.put(id, mock);

        return mock;
    }
}
