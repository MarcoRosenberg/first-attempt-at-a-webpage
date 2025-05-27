using System.Collections.Generic;
using UnityEngine;

public class SimpleTextGameEngine : MonoBehaviour
{
    // Player state
    private string currentLocation = "start";
    private int health = 100;

    // Simple map structure
    private Dictionary<string, Location> gameMap = new Dictionary<string, Location>();

    void Start()
    {
        // Initialize game map
        gameMap["start"] = new Location("You are at the start of your adventure.", new List<string> { "forest" });
        gameMap["forest"] = new Location("A dark forest. Paths lead to a river or back to start.", new List<string> { "river", "start" });
        gameMap["river"] = new Location("A flowing river blocks your path.", new List<string> { "forest" });

        Debug.Log("Welcome to the simple Unity text adventure!");
        DescribeLocation();
    }

    void Update()
    {
        // Check for player input (for demo purposes, simple keys)
        if (Input.GetKeyDown(KeyCode.M))
        {
            // Move command: for demo, move to first available path
            MoveToNextLocation();
        }
        else if (Input.GetKeyDown(KeyCode.R))
        {
            Rest();
        }
    }

    void MoveToNextLocation()
    {
        List<string> paths = gameMap[currentLocation].Paths;
        if (paths.Count > 0)
        {
            currentLocation = paths[0];
            Debug.Log($"You move to {currentLocation}.");
            DescribeLocation();
        }
        else
        {
            Debug.Log("No paths available to move.");
        }
    }

    void Rest()
    {
        health = Mathf.Min(health + 10, 100);
        Debug.Log($"You rest and recover health. Health is now {health}.");
    }

    void DescribeLocation()
    {
        Debug.Log(gameMap[currentLocation].Description);
        Debug.Log("You can go to: " + string.Join(", ", gameMap[currentLocation].Paths));
        Debug.Log($"Health: {health}");
        Debug.Log("Press M to move to the next location, R to rest.");
    }

    class Location
    {
        public string Description;
        public List<string> Paths;

        public Location(string description, List<string> paths)
        {
            Description = description;
            Paths = paths;
        }
    }
}
