/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testresourcemanager;

/**
 *
 * @author Nicolo'
 */
public class ResourceManager {
    private int readers, writers, blockedWriters;

    public ResourceManager() {
        readers = writers = blockedWriters = 0;
    }

    public synchronized void beginRead() {
        while (writers > 0 || blockedWriters > 0) try {
            wait();
        } catch (InterruptedException e) {
        }
        readers += 1;
    }

    public synchronized void endRead() {
        while (writers > 0 || blockedWriters > 0) try {
            wait();
        } catch (InterruptedException e) {
        }
        readers -= 1;
        if (readers == 0)
            notifyAll();
    }

    public synchronized void beginWrite() {
        blockedWriters += 1;
        while (readers > 0 || writers > 0) try {
            wait();
        } catch (InterruptedException e) {
        }
        blockedWriters -= 1;
        writers += 1;
    }

    public synchronized void endWrite() {
        while (readers > 0 || writers > 0) try {
            wait();
        } catch (InterruptedException e) {
        }
        writers -= 1;
        if (writers == 0)
            notifyAll();
    }
}